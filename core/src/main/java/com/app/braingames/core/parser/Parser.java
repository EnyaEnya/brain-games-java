package com.app.braingames.core.parser;

import javax.xml.bind.JAXBException;
import java.io.File;

public interface Parser {
    <T> T getObject(File file, Class<T> c) throws JAXBException;
    void saveObject(File file, Object o) throws JAXBException;
}
