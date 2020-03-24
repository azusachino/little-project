package cn.az.card.merchant.vo;

import cn.az.card.merchant.entity.Merchant;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author az
 * @date 2020/3/17
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MerchantRequest {

    private String name;

    private String logoUrl;

    private String businessLicenseUrl;

    private String phone;

    private String address;

    /**
     *
     * @return {@link Merchant}
     */
    public Merchant toMerchant() {
        Merchant merchant = new Merchant();

        merchant.setName(this.name);
        merchant.setLogoUrl(this.logoUrl);
        merchant.setBusinessLicenseUrl(this.businessLicenseUrl);
        merchant.setPhone(this.phone);
        merchant.setAddress(this.address);

        return merchant;
    }

}
