package card.ygo.service.impl;

import card.ygo.mapper.CardMapper;
import card.ygo.pojo.Card;
import card.ygo.pojo.CardCheckName;
import card.ygo.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardServiceImpl implements CardService {
    @Autowired
    private CardMapper cardMapper;
    @Override
    public List<CardCheckName> listName(String name) {
        return cardMapper.listName(name);
    }

    @Override
    public Card detail(Long id) {
        return cardMapper.detail(id);
    }
}
