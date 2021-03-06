package userInterface;

import net.serenitybdd.screenplay.targets.Target;

public class AdidasUserInterface {

	public static final Target TXT_BUSCADOR_ADIDAS = Target.the("El campo donde se realiza la busque del producto").locatedBy("//input[@class='searchinput___zXLAR']");
	public static final Target BTN_PRODUCTO_ADIDAS = Target.the("Ancla del producto").locatedBy("(//img[contains(@title,'{0}')]//ancestor::a)[1]");
	public static final Target BTN_CLOSE_WINDOW_EMERGENTE = Target.the("Button para cerrar (X)").locatedBy("//button[@class='gl-modal__close']");
	public static final Target LBL_PRODUCTO_ADIDAS = Target.the("Nombre de producto en el Detalle").locatedBy("//div[@class='product-description___2cJO2']/child::h1//span");
	public static final Target BTN_PRODUCTO_ALEATORIO_ADIDAS=Target.the("Ancla para botones de en la card list").locatedBy("//div[@class='gl-product-card__assets']//a");
	public static final Target LBL_PRODUCTO_ALEATORIO_ADIDAS=Target.the("Texto de las card list").locatedBy("//div[@class='grid-item___3rAkS']//div[@class='gl-product-card__details']/p[@data-auto-id='product-card-title']");
	public static final Target BTN_CATEGORY_HOMBRE=Target.the("Button de categoria Hombre").locatedBy("//div[@data-auto-id='glass-navigation-flyout']/a[contains(text(),'HOMBRE')]");
	public static final Target BTN_CATEGORY_TENIS = Target.the("Button de subcategoria Tenis").locatedBy("//span[contains(text(),'Tenis')]//ancestor::button");

}
