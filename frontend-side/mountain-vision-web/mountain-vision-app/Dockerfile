# Usa a imagem oficial do Node.js
FROM node:18

# Instala o pnpm globalmente
RUN npm install -g pnpm

# Define o diretório de trabalho dentro do container
WORKDIR /app

# Copia os arquivos de dependências
COPY package.json pnpm-lock.yaml ./

# Instala as dependências
RUN pnpm install

# Copia o restante da aplicação
COPY . .

# Corrige permissões
RUN chmod -R 755 /app

# Expõe a porta padrão do Next.js
EXPOSE 3000

# Comando para rodar o servidor de desenvolvimento
CMD ["node_modules/.bin/next", "dev"]

