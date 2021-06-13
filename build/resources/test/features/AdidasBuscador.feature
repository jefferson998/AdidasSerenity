Feature: HU-001 Buscador Adidas
  Yo como usuario de Adidas
  Quiero buscar en el buscador un producto
  Para ver el producto en la pagina

  Scenario Outline:  <Escenario>
    Given Me encuentro en la pagina de Adidas url <url>
    When Buscar el producto <Producto> en el buscador
    Then ver el producto <Producto> y validarlo

    Examples:
      | Escenario                         | Producto                                    | url                    |
      | Buscar producto en Adidas exitoso | Tenis 4D FUSIO                              | https://www.adidas.co/ |
      | Buscar producto en Adidas exitoso | Tapabocas Adidas (Pack de 3)                | https://www.adidas.co/ |
      | Buscar producto en Adidas exitoso | Tenis NMD_R1                                | https://www.adidas.co/ |
      | Buscar producto en Adidas exitoso | Buzo con Capucha Trifolio                   | https://www.adidas.co/ |
      | Buscar producto en Adidas exitoso | Camiseta Titular Oficial Selección Colombia | https://www.adidas.co/ |