package com.example.gulshanclubmanagement.Md_Atikul_Islam_2521757;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class AppendableObjectOutputStream extends ObjectOutputStream {
    public AppendableObjectOutputStream(OutputStream out) throws IOException {
        super(out);

    }

    @Override
    protected void writeStreamHeader() throws IOException {

    }
}
