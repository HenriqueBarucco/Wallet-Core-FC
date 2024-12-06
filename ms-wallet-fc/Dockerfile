FROM golang:1.23.2

WORKDIR /app/

RUN apt-get update && apt-get install -y librdkafka-dev

COPY . .

RUN go mod download

RUN go build -o /walletcore cmd/walletcore/main.go

CMD ["/walletcore"]