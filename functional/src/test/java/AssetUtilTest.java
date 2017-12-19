import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class AssetUtilTest {

    private List<Asset> assets;

    @Before
    public void setUp() {
        assets = asList(
                new Asset(Asset.AssetType.BOND, 1000),
                new Asset(Asset.AssetType.BOND, 2000),
                new Asset(Asset.AssetType.STOCK, 3000),
                new Asset(Asset.AssetType.STOCK, 4000)
        );
    }

    @Test
    public void should_calculate_all_asset_values() {
        int totalAssetValues = AssetUtil.totalAssetValues(assets, asset -> true);
        assertThat(totalAssetValues, is(10000));
        System.out.println("Total of all assets: " + totalAssetValues);
    }

    @Test
    public void should_calculate_all_stock_values() {
        int totalStockValues = AssetUtil.totalAssetValues(assets, asset -> asset.getType() == Asset.AssetType.STOCK);
        assertThat(totalStockValues, is(7000));
        System.out.println("Total of all block assets: " + totalStockValues);
    }

    @Test
    public void should_calculate_all_bond_values() {
        int totalBondValues = AssetUtil.totalAssetValues(assets, asset -> asset.getType() == Asset.AssetType.BOND);
        assertThat(totalBondValues, is(3000));
        System.out.println("Total of all bond assets: " + totalBondValues);
    }
}
