package org.example.ReadingAndWriting;

import org.example.Interfaces.ReadingAndWritingInterface;

public abstract class FileReaderWriter implements ReadingAndWritingInterface {
    protected ReadingAndWritingInterface rw;
    protected String name;
    public FileReaderWriter(ReadingAndWritingInterface rw) {
        this.rw = rw;
        this.name = rw.getFileName();
    }

    @Override
    public String getFileName() {
        return this.name;
    }
}
