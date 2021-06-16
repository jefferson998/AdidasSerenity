Feature: HU-004 Buscador Adidas Fallido/exitoso
  Yo como usuario de Adidas
  Quiero buscar en el buscador un producto
  Para ver el producto en la pagina

  Scenario Outline:  <Escenario>
    Given Me encuentro en la pagina de Adidas en la url <url>
    When Buscar el producto <Producto> en el buscador exitoso o fallido
    Then ver el producto <Producto> y validarlo si es correcto o incorrecto

    Examples:
      | Escenario                         | Producto        | url                    |
      | Buscar producto en Adidas Fallido | tenis quesoplus | https://www.adidas.co/ |