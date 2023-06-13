package com.example.filescan.service;

import com.example.filescan.dto.VirusScanResult;
import org.springframework.web.multipart.MultipartFile;

public interface VirusScanService {

    VirusScanResult virusScan(MultipartFile file);

}