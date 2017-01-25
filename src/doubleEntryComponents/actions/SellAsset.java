package doubleEntryComponents.actions;

import doubleEntryComponents.Bank;
import doubleEntryComponents.contracts.Asset;

public class SellAsset extends Action {

    private Asset asset;

    public SellAsset(Asset asset) {
        this.asset = asset;
        setAmount(0.0);
    }

    @Override
    public void perform() {
        Bank owner = (Bank) asset.getAssetParty();
        asset.sellAmount(getAmount());
        owner.getGeneralLedger().sellAsset(getAmount());
    }

    @Override
    public double getMax() {
        return asset.getValue();
    }

    @Override
    public void print() {
        System.out.println("Sell Asset action by "+asset.getAssetParty().getName()+" -> asset type: "+asset.getAssetType() +"amount: "+getAmount());
    }
}