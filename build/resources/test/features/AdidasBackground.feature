Feature: HU-003 Buscador Adidas Background
  Yo como usuario de Adidas
  Quiero buscar en el buscador un producto
  Para ver el producto en la pagina

  Background:
    Given Me encuentro en la pagina de Adidas url https://www.adidas.co/

  Scenario: Buscar producto en Adidas
    When Buscar un producto en el buscador
      | nameProduct    |
      | Tenis 4D FUSIO |
    Then ver el producto y validarlo

  Scenario: Buscar producto en Adidas
    When Buscar un producto en el buscador
      | nameProduct                  |
      | Tapabocas Adidas (Pack de 3) |
    Then ver el producto y validarlo


