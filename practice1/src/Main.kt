// Класс для хранения информации о расходе
class Expense(val amount: Double, val category: String, val date: String) {

    // Метод для вывода информации о конкретном расходе
    fun printExpense() {
        println("Сумма: $amount, Категория: $category, Дата: $date")
    }
}

// Класс для управления списком всех расходов
class ExpenseManager {

    // Список для хранения всех расходов
    private val expenses = mutableListOf<Expense>()

    // Метод для добавления нового расхода
    fun addExpense(amount: Double, category: String, date: String) {
        val expense = Expense(amount, category, date)
        expenses.add(expense);
        println("Расход добавлен: Сумма - $amount, Категория - $category, Дата - $date")
    }

    // Метод для вывода всех расходов
    fun printAllExpenses() {
        if(expenses.isEmpty()) {
            println("Расходов нет")
        } else {
            for (expense in expenses) {
                expense.printExpense()
            }
        }
    }

    // Метод для подсчета суммы расходов по каждой категории
    fun calculateTotalByCategory() {
        if (expenses.isEmpty()) {
            println("Расходов нет")
        } else {
            val categoryTotals = mutableMapOf<String, Double>()

            for (expense in expenses) {
                val currentTotal = categoryTotals.getOrDefault(expense.category, 0.0)
                categoryTotals[expense.category] = currentTotal + expense.amount;
            }

            println("Сумма расходов по категориям:")
            for ((category, total) in categoryTotals)
                println("Категория: $category, Общая сумма: $total")
        }
    }
}

fun main() {
    val expenseManager = ExpenseManager()

    expenseManager.addExpense(100.0, "Еда", "2024-10-01")
    expenseManager.addExpense(50.0, "Транспорт", "2024-10-02")
    expenseManager.addExpense(200.0, "Одежда", "2024-10-02")
    expenseManager.addExpense(70.0, "Еда", "2024-10-03")

    println("\nВсе расходы:")
    expenseManager.printAllExpenses()

    println("\nОбщая сумма по категориям:")
    expenseManager.calculateTotalByCategory()
}