package com.workspace.fileHandling.Controllers;

import com.workspace.fileHandling.DTO.xmlDTO;
import com.workspace.fileHandling.Zipper;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import static java.lang.String.*;

@RestController
@CrossOrigin("http://localhost:4200")
public class MainController {
    private File zippedFile;
    @PostMapping(path="/trailhome", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity zipFile(@RequestBody final xmlDTO xmlVal){
        System.out.println("Hello");
        Zipper zipperObject=new Zipper();
        zippedFile= zipperObject.zip(xmlVal.getFileValue(), xmlVal.getFileName());
        return  ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping(path="/download")
    public ResponseEntity<Object> downloadFile() throws FileNotFoundException {
        InputStreamResource isr= new InputStreamResource(new FileInputStream(zippedFile));
        HttpHeaders headers= new HttpHeaders();
        headers.add("Content-Disposition", format("attachment:filename=\'%s\'",zippedFile.getName()));
        headers.add("Cache-Control","no-cache,no-store,must-revalidate");
        headers.add("Pragma","no-cache");
        headers.add("Expires","0");
        ResponseEntity<Object> responseEntity= ResponseEntity.ok().headers(headers).contentLength(zippedFile.length()).contentType(MediaType.parseMediaType("application/zip")).body(isr);
        return responseEntity;
    }
}
