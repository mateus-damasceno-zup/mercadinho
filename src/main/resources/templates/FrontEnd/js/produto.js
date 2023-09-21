const listarprodutos = document.getElementById("listarprodutos");

if (listarprodutos) {
    listarprodutos.addEventListener("click", () => {
        buscaTodosProdutos();
    });
}
function buscaTodosProdutos() {
    const url = "http://localhost:8080/produtos"

    fetch(url)
        .then((data) => {
            return data.json();
        })
        .then((todosProdutos) => {
            let data1 = "";
            todosProdutos.forEach((values) => {
                data1 += `
            <tr>
              <th scope="row">${values.id}</th>
              <td>${values.nomeProduto}</td>
              <td>${values.descricao}</td>
              <td>${values.preco}</td>
            </tr>
          `;
            });
            document.getElementById("table-produtos").innerHTML = data1;
        })
        .catch((error) => {
            console.error("Ocorreu um erro durante a solicitação:", error);
        });
}

function buscaProdutoPorId() {
    const id = document.getElementById("idBusca").value;
    const url = `http://localhost:8080/produtos/${id}`;
    
    fetch(url)
        .then((data) => {
            if (!data.ok) {
                throw new Error(`O produto de ID ${id} não foi encontrado`);
            }
            return data.json();
        })
        .then((produto) => {
            const tabela = document.getElementById("tabelaResultado").querySelector("tbody");
            tabela.innerHTML = ""; 

            const linhaProduto = `
            <tr>
            <th scope="row">${values.id}</th>
            <td>${values.nomeProduto}</td>
            <td>${values.descricao}</td>
            <td>${values.preco}</td>
          </tr>
            `;

            tabela.innerHTML = linhaProduto;
        })
        .catch((error) => {
            console.log("Erro ao buscar o produto: ", error);
        });
}