package transportes.abdel.pojoabdel;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "provincias")
public class Provincias {
    private List<Provincia> provinciaList;

    @XmlElement(name = "provincia")
    public List<Provincia> getProvinciaList() {
        return provinciaList;
    }

    public void setProvinciaList(List<Provincia> provinciaList) {
        this.provinciaList = provinciaList;
    }
}

