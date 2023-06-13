package com.example.filescan.service;

import com.example.filescan.dto.VirusScanResult;

import java.io.IOException;
import java.io.InputStream;



public interface ClamAVService {

    boolean ping();

    VirusScanResult scan(InputStream inputStream) throws IOException;

}