1) Baseado no que vimos em aula, utilize os padrões MVC, Singleton e DAO para resolver
o seguinte contexto. Utilize, quando necessário, os demais conceitos vistos (Interface,
Polimorfismo, Classe abstrata, Sobrecarga etc.).
Um software gerencia a venda de diversas categorias de produtos. Cada produto tem
um código de identificação, descrição básica, um preço e uma quantidade em estoque.
Assim, o usuário é capaz de comprar esses produtos através do terminal.
As categorias de produtos que o software vende são: Relógios e Perfumes. Esses
produtos estão organizados em um estoque de produtos, sendo o banco de dados. Os
dados adicionais de cada categoria são:
- Relógios: marca e tipo (mecânico, quartz ou digital)
- Perfumes: marca e tamanho em mililitros
Dessa forma, são necessidades obrigatórias do software as seguintes operações:
- Cadastrar produtos no banco de dados;
- Consultar produtos no banco de dados;
- Realizar a compra de produtos e exibir um relatório das informações dos produtos e
valor total da compra. Dica: Para facilitar, você poderá criar uma lista de produtos
comprados dentro do método main, a qual guardará as informações da compra.
Você deverá fazer todas as validações e regras necessárias para garantir a atualização
do banco de dados. Exemplo: Caso um produto seja vendido, isso deverá reduzir as
unidades no banco de dados.
