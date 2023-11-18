package transportes.abdel.xmlabdel;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import transportes.abdel.pojoabdel.Provincias;

import java.io.File;

public class XmlHandler {
    public static Provincias cargarDatosDesdeXML(String nombreArchivo) {
        try {
            JAXBContext context = JAXBContext.newInstance(Provincias.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            return (Provincias) unmarshaller.unmarshal(new File(nombreArchivo));
        } catch (JAXBException e) {
            e.printStackTrace();
            return null;
        }
    }
}
