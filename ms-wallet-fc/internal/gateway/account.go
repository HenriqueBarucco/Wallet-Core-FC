package gateway

import "github.com/HenriqueBarucco/Wallet-Core-FC/internal/entity"

type AccountGateway interface {
	Save(account *entity.Account) error
	FindByID(id string) (*entity.Account, error)
	UpdateBalance(account *entity.Account) error
}
