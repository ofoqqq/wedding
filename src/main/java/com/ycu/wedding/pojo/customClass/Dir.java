package com.ycu.wedding.pojo.customClass;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Dir {

    @Value("${avatar.upLoad-WinDir}")
    private String winDir;

    @Value("${avatar.upLoad-LinuxDir}")
    private String linuxDir;

    public String getWinDir() {
        return winDir;
    }

    public void setWinDir(String winDir) {
        this.winDir = winDir;
    }

    public String getLinuxDir() {
        return linuxDir;
    }

    public void setLinuxDir(String linuxDir) {
        this.linuxDir = linuxDir;
    }
}
