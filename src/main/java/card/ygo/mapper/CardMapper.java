package card.ygo.mapper;

import card.ygo.pojo.Card;
import card.ygo.pojo.CardCheckName;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface CardMapper {
    public List<CardCheckName> listName(@Param("name")String name);

    public Card detail(@Param("id")Long id);
}
