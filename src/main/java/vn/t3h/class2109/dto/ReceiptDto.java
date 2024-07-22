package vn.t3h.class2109.dto;


import lombok.Data;
import vn.t3h.class2109.entities.ReceiptEntity;

@Data
public class ReceiptDto {
    Long id;
    Long productid;
    Long userid;
    String productimg;
    int number;
    Long productprice;
    String productname;

//    public ReceiptEntity mapperEntity() {
//        ReceiptEntity receiptEntity = new ReceiptEntity();
//        receiptEntity.setId(id);
//        receiptEntity.setProductid(productid);
//        receiptEntity.setUserid(userid);
//        receiptEntity.setProductimg(productimg);
//        receiptEntity.setNumber(number);
//        return receiptEntity;
//    }
}
