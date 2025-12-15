git checkout -b ft-refactor
git add .
git commit -m "refactoring and changing the filing system"
git add .
git commit -m "Refactored Account and TransactionManager"
git push origin ft-refactor

git checkout  -b feature/exceptions
git add .
git commit -m "Added custom exceptions and enhanced error handling"
git push origin feature/exceptions

git checkout -b feature/testing
git add .
git commit -m "adding test and transaction between accounts"
git add .
git commit -m "testing logs"
git add .
git commit -m "fixing testing"