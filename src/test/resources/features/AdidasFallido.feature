Feature: HU-004 Buscador Adidas Fallido/exitoso
  Yo como usuario de Adidas
  Quiero buscar en el buscador un producto
  Para ver el producto en la pagina

  Scenario:Buscar algo que no exista -->Fallido
    Given Me encuentro en la pagina de Adidas en la url https://www.adidas.co/
    When Buscar el producto en el buscador
    |nameProduct|
    |Tenis de queso|
    Then ver el producto y validarlo si se encuentra o no

  Scenario:Buscar un producto existente en la tienda -->Exitoso
    Given Me encuentro en la pagina de Adidas en la url https://www.adidas.co/
    When Buscar el producto en el buscador
      |nameProduct|
      |Tenis X9000L4|
    Then ver el producto y validarlo si se encuentra o no
