package com.promineotech.seeds;

import org.springframework.boot.SpringApplication;   
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.promineotech.ComponentsScanMarker;


@SpringBootApplication(scanBasePackageClasses = {ComponentsScanMarker.class})
public class SeedStore {

  public static void main(String[] args) {
    SpringApplication.run(SeedStore.class, args);
  }
 
}