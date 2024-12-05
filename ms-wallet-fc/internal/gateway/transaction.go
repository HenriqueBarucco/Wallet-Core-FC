package gateway

import "github.com/HenriqueBarucco/Wallet-Core-FC/internal/entity"

type TransactionGateway interface {
	Create(transaction *entity.Transaction) error
}
