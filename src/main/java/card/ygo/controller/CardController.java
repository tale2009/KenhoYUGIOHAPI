package card.ygo.controller;


import card.ygo.pojo.Card;
import card.ygo.pojo.CardCheckName;
import card.ygo.pojo.ReturnCard;
import card.ygo.pojo.ReturnName;
import card.ygo.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.List;


@CrossOrigin
@RestController
public class CardController {
    @Autowired
    private CardService cardService;

    @GetMapping("/api/yugioh/card")
    public ReturnName listName(@RequestParam String name)  {
        ReturnName returnName=new ReturnName();
        returnName.setData(cardService.listName(name));
        return returnName;
    }

    @GetMapping("/api/yugioh/card/{id}")
    public ReturnCard listName(@PathVariable("id")Long id)  {
        ReturnCard card=new ReturnCard();
        card.setData(cardService.detail(id));
        return card;
    }

    @GetMapping(value = "/images/{id}",produces = MediaType.IMAGE_JPEG_VALUE)
    public byte[] getImage(@PathVariable("id")Long id) throws IOException {
        BufferedImage read = ImageIO.read(new FileInputStream(new File("D:\\card\\img\\"+id+".jpg")));
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ImageIO.write(read, "jpg", out);
        return out.toByteArray();
    }

    @GetMapping(value = "/yugioh/image/{id}.png",produces = MediaType.IMAGE_JPEG_VALUE)
    public byte[] getbackgroupImage(@PathVariable("id")String id) throws IOException {
        BufferedImage read = ImageIO.read(new FileInputStream(new File("D:\\card\\backgroup\\"+id+".png")));
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ImageIO.write(read, "png", out);
        return out.toByteArray();
    }

    @GetMapping(value = "/yugioh/svg/{svg}", produces = {
            "image/svg+xml"
    })
    public byte[] getsvg(@PathVariable("svg")String svg) throws IOException {//括号里参数为文件图片路径
        byte[] data = new byte[0];
        String inputFile = "D:\\card\\backgroup\\"+svg;
        try {
            InputStream inputStream = new FileInputStream(inputFile);
            long fileSize = new File(inputFile).length();
            data = new byte[(int) fileSize];
            inputStream.read(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }
}