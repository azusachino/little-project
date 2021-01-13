package cn.az.project.mall.dao;

import cn.az.project.mall.nosql.es.document.EsProduct;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * The interface Es product dao.
 *
 * @author Liz
 */
public interface EsProductDao {

    /**
     * Gets all es product list.
     *
     * @param id the id
     * @return the all es product list
     */
    @Select(" <script> select\n" +
        " p.id id,\n" +
        " p.product_sn productSn,\n" +
        " p.brand_id brandId,\n" +
        " p.brand_name brandName,\n" +
        " p.product_category_id productCategoryId,\n" +
        " p.product_category_name productCategoryName,\n" +
        " p.pic pic,\n" +
        " p.name name,\n" +
        " p.sub_title subTitle,\n" +
        " p.price price,\n" +
        " p.sale sale,\n" +
        " p.new_status newStatus,\n" +
        " p.recommand_status recommandStatus,\n" +
        " p.stock stock,\n" +
        " p.promotion_type promotionType,\n" +
        " p.keywords keywords,\n" +
        " p.sort sort,\n" +
        " pav.id attr_id,\n" +
        " pav.value attr_value,\n" +
        " pav.product_attribute_id attr_product_attribute_id,\n" +
        " pa.type attr_type,\n" +
        " pa.name attr_name\n" +
        " from pms_product p\n" +
        " left join pms_product_attribute_value pav on p.id = pav.product_id\n" +
        " left join pms_product_attribute pa on pav.product_attribute_id= pa.id\n" +
        " where delete_status = 0 and publish_status = 1\n" +
        " <if test=\"id!=null\">\n" +
        " and p.id=#{id}\n" +
        " </if>" +
        "</script>")
    List<EsProduct> getAllEsProductList(@Param("id") Long id);


}
