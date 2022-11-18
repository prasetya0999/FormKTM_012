/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pwsA.formKTM_20200140012;

import java.io.IOException;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Administrator
 */
@Controller
public class MyController {
    @RequestMapping("/take")
    public String next(
            @RequestParam(value = "nama") String isiPertama,
            @RequestParam(value = "nim") String isiKedua,
            @RequestParam(value = "prodi") String isiKetiga,
            @RequestParam(value = "emaill") String isiKeempat,
            @RequestParam(value ="pic") MultipartFile isiKelima,
            Model kurir)
    throws IOException{
        byte[] img = isiKelima.getBytes();
        String base64Image = Base64.encodeBase64String(img);
        String imglink ="data:image/png;base64,".concat(base64Image);
        kurir.addAttribute("paket1",isiPertama);
        kurir.addAttribute("paket2",isiKedua);
        kurir.addAttribute("paket3",isiKetiga);
        kurir.addAttribute("paket4",isiKeempat);
        kurir.addAttribute("paket5",imglink);
    
        return "views";
    }
    
}
