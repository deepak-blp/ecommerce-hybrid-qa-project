package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.CartPage;
import pages.LoginPage;
import pages.ProductPage;
import utils.ScreenshotUtil;

public class AddToCartTest extends BaseTest {

    @Test
    public void addProductToCartTest() {

        LoginPage loginPage =
                new LoginPage(driver);

        loginPage.loginToApplication(
                "standard_user",
                "secret_sauce"
        );

        ProductPage productPage =
                new ProductPage(driver);

        productPage.addProductToCart();

        productPage.openCart();

        CartPage cartPage =
                new CartPage(driver);

        String actualProduct =
                cartPage.getCartProductName();

        Assert.assertEquals(
                actualProduct,
                "Sauce Labs Backpack"
        );

        ScreenshotUtil.captureScreenshot(
        driver,
        "AddToCartTest"
        );
    }
}