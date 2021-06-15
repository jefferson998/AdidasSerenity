package userInterface;

import net.serenitybdd.screenplay.targets.Target;

public class AdidasUserInterface {

	public static final Target TXT_BUSCADOR_ADIDAS = Target.the("El campo donde se realiza la busque del producto").locatedBy("//input[@class='searchinput___zXLAR']");
	public static final Target BTN_PRODUCTO_ADIDAS = Target.the("").locatedBy("(//span[@title='{0}']//ancestor::a)[1]");

	public static final Target BTN_CLOSE_WINDOW_EMERGENTE = Target.the("").locatedBy("//button[@class='gl-modal__close']");
	public static final Target LBL_PRODUCTO_ADIDAS = Target.the("").locatedBy("//div[@class='product-description___2cJO2']/child::h1//span");
	//categorias aleatorios
	public static final Target BTN_PRODUCTO_ALEATORIO_ADIDAS=Target.the("").locatedBy("//div[@class='gl-product-card__assets']//a");
	public static final Target LBL_PRODUCTO_ALEATORIO_ADIDAS=Target.the("").locatedBy("//div[@class='grid-item___3rAkS']//div[@class='gl-product-card__details']/p[@data-auto-id='product-card-title']");
	//categorias
	public static final Target BTN_CATEGORY_HOMBRE=Target.the("").locatedBy("//div[@data-auto-id='glass-navigation-flyout']/a[contains(text(),'HOMBRE')]");
	public static final Target BTN_CATEGORY_TENIS = Target.the("").locatedBy("//span[contains(text(),'Tenis')]//ancestor::button");

}
