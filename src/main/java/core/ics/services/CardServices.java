package core.ics.services;

import core.ics.model.Card;
import core.ics.repository.CardRepository;
import core.ics.status.CardStatus;
import core.ics.utils.ValidateParameter;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@ApplicationScoped
public class CardServices {

    @Inject
    CardRepository cardRepository;

    public Card saveCard(){

        String[] flag_card = {"VISA", "MASTERCARD", "MAESTRO", "AMERICAN_EXPRESS", "DINERS", "ELO"};
        Random random = new SecureRandom();
        int random_flag = random.nextInt(6);

        Card card = Card
                .builder()
                .cardNumber(first_quartil()+" "+second_quartil()+" "+third_quartil()+" "+quarter_quartil())
                .cvv(cvv())
                .flagCard(flag_card[random_flag])
                .status(CardStatus.ACTIVE.toString())
                .build();

        cardRepository.persist(card);

        return card;
    }

    private String first_quartil(){

        Integer[] d1 = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        Integer[] d2 = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        Integer[] d3 = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        Integer[] d4 = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

        Random random = new SecureRandom();
        int r1 = random.nextInt(10);
        int r2 = random.nextInt(10);
        int r3 = random.nextInt(10);
        int r4 = random.nextInt(10);

        String fq = d1[r1].toString()+d2[r2].toString()+d3[r3].toString()+d4[r4].toString();

        return fq;
    }

    private String second_quartil(){

        Integer[] d1 = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        Integer[] d2 = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        Integer[] d3 = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        Integer[] d4 = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

        Random random = new SecureRandom();
        int r1 = random.nextInt(10);
        int r2 = random.nextInt(10);
        int r3 = random.nextInt(10);
        int r4 = random.nextInt(10);

        String sq = d1[r1].toString()+d2[r2].toString()+d3[r3].toString()+d4[r4].toString();

        return sq;
    }

    private String third_quartil(){

        Integer[] d1 = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        Integer[] d2 = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        Integer[] d3 = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        Integer[] d4 = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

        Random random = new SecureRandom();
        int r1 = random.nextInt(10);
        int r2 = random.nextInt(10);
        int r3 = random.nextInt(10);
        int r4 = random.nextInt(10);

        String tq = d1[r1].toString()+d2[r2].toString()+d3[r3].toString()+d4[r4].toString();

        return tq;
    }

    private String quarter_quartil(){

        Integer[] d1 = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        Integer[] d2 = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        Integer[] d3 = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        Integer[] d4 = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

        Random random = new SecureRandom();
        int r1 = random.nextInt(10);
        int r2 = random.nextInt(10);
        int r3 = random.nextInt(10);
        int r4 = random.nextInt(10);

        String qq = d1[r1].toString()+d2[r2].toString()+d3[r3].toString()+d4[r4].toString();

        return qq;
    }

    private String cvv(){

        Integer[] d1 = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        Integer[] d2 = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        Integer[] d3 = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

        Random random = new SecureRandom();
        int r1 = random.nextInt(10);
        int r2 = random.nextInt(10);
        int r3 = random.nextInt(10);

        String cvv = d1[r1].toString()+d2[r2].toString()+d3[r3].toString();

        return cvv;
    }

    public Card findCardByID(String value){
        Long id = ValidateParameter.validate(value);
        return cardRepository.findById(id);
    }

    public List<Card> list(){
        return cardRepository.listAll();
    }
}
