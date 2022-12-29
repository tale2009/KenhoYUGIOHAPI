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
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
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
}
