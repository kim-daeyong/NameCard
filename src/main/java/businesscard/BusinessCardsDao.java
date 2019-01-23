package businesscard;


import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class BusinessCardsDao implements BusinessCardDao {

    private BusinessCardData businessCardData;

    public BusinessCardsDao() {
        businessCardData = new BusinessCardData();
    }

    @Override
    public List<BusinessCard> getList(String number) {
        return null;
    }

    @Override
    public List<BusinessCard> find(String name, String phone) {
        List<BusinessCard> findList = new ArrayList<>();
        try{
            for(BusinessCard bc : businessCardData.getBusinessCards() ){
                if(bc.getName().contains(name)||bc.getPhone().contains(phone)){
                    findList.add(bc);
                }

            }
            System.out.print(findList);
        }
        catch(Exception ec){
            System.out.println(ec);
        }
        return findList;
    }

    @Override
    public boolean insert(BusinessCard businessCard) {
        boolean flag = true;
        try{
            flag = true;
            businessCard.setId(businessCardData.getMaxNum());
            businessCardData.add(businessCard);
            save("/Users/bigyo/DEVEL/tmp/businesscard.json");

        }
        catch(Exception ec){
            flag = false;
            System.out.println(ec);

        }

        return flag;
    }

    @Override
    public boolean update(String id, String key, String value) {
        boolean flag = true;
        String result;
        try {
            flag = true;
            List<BusinessCard> list = businessCardData.getBusinessCards();
            for(BusinessCard bc : list) {
                result = Integer.toString(bc.getId());
                if(result.equals(id)) {
                    if(key.equals("1")) {
                        bc.setName(value);
                    } else if(key.equals("2")) {
                        bc.setPhone(value);
                    } else {
                        bc.setCompany(value);
                    }
                    save("/Users/bigyo/DEVEL/tmp/businesscard.json");
                }
            }
        } catch(Exception em) {
            flag = false;
            System.out.println(em);
        }

        return flag;
    }

    @Override
    public boolean remove(String id) {

        boolean flag = true;
        String result;
        try {
            flag = true;
            List<BusinessCard> list = new ArrayList<>();
            for (BusinessCard businessCard : list) {
                result = Integer.toString(businessCard.getId());
                if(result.equals(id)){
                    list.remove(id);
                    save("/Users/bigyo/DEVEL/tmp/businesscard.json");
                }

            }

        } catch (Exception ec) {
            flag = false;
            System.out.println("ex");

        }

        return flag;
    }

    @Override
    public boolean save(String pathname) {
        ObjectMapper objectMapper = new ObjectMapper();
        boolean flag = true;
        File file = new File("/Users/bigyo/DEVEL/tmp/businesscard.json");
        try {
            objectMapper.writeValue(file, businessCardData);
            flag = true;
        } catch(Exception em) {
            System.out.println(em);
            flag = false;
        }
        return flag;
    }

    @Override
    public boolean load(String pathname) {
            ObjectMapper objectMapper = new ObjectMapper();
            boolean flag = false;
            File file = new File("/Users/bigyo/DEVEL/tmp/businesscard.json");
            try {
                flag = true;
                businessCardData = objectMapper.readValue(file, BusinessCardData.class);
            } catch (Exception em) {
                flag = false;
                System.out.println(em);
            }
            return flag;

    }


}