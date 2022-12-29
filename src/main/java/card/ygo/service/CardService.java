package card.ygo.service;

import card.ygo.pojo.Card;
import card.ygo.pojo.CardCheckName;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;


public interface CardService {
    public List<CardCheckName> listName(String name);

    public Card detail(Long id);
}
