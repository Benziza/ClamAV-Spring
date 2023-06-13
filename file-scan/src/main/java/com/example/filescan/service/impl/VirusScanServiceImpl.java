package com.example.filescan.service.impl;

import java.io.InputStream;

import com.example.filescan.dto.VirusScanResult;
import com.example.filescan.enums.VirusScanStatus;
import com.example.filescan.service.ClamAVService;
import com.example.filescan.service.VirusScanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class VirusScanServiceImpl implements VirusScanService {

    @Autowired
    private ClamAVService clamAVService;

    @Override
    public VirusScanResult virusScan(final MultipartFile file) {
        VirusScanResult scanResult = null;

        try (InputStream destStream = file.getInputStream()) {
            if (clamAVService.ping()) {
                scanResult = clamAVService.scan(destStream);

            } else {
                log.error("ClamD did not respond to ping request.");
                scanResult = new VirusScanResult(VirusScanStatus.CONNECTION_FAILED,
                        "ClamAV did not respond to ping request.");
            }
        } catch (Exception e) {
            log.error("An error occurred while scanning file.", e);
            scanResult =
                    new VirusScanResult(VirusScanStatus.ERROR, "An error occurred while scanning file.");
        }

        return scanResult;
    }

}