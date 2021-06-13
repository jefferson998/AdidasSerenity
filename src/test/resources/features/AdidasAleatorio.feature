Feature: HU-002 Buscador Adidas Aleatorio
  Yo como usuario de Adidas
  Quiero buscar en el buscador un producto
  Para ver el producto en la pagina

  Scenario Outline: <Escenario>
    Given Me encuentro en la pagina de Adidas url <url>
    When Buscar un producto aleatorio en el buscador
    Then ver un producto aleatorio y validarlo
    Examples:
      | Escenario                         | url                    |
      | Buscar producto en Adidas exitoso | https://www.adidas.co/ |

