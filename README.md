## Как всё склонировать и запустить

1. Склонировать репу:
   ```bash
   git clone https://github.com/VGorHub/SHIFT-Course-Task-2025.git
   ```
2. Зайти в корень проекта:
   ```bash
   cd shift-course-task
   ```

3. Собрать проект:
   ```bash
   ./gradlew build
   ```
   > Если у вас винда, то `gradlew.bat build` ну или через графический интерфейс IDEA 
    
### Есть 2 способа через Gradle run и через толстый JAR

4. Запустить через Gradle run(Я все тестил так):
   ```bash
   ./gradlew run --args="-s -a -p sample- in1.txt in2.txt"
   ```
   > На винде: `gradlew.bat run --args="-s -a -p sample- in1.txt in2.txt"`

   Тут `in1.txt` и `in2.txt` — это входные файлы (я их подготовил заранее)
   Ключи `-s -a -p sample-` включают краткую статистику, добавление к уже существующим файлам и префикс `sample-` для выходных файлов


5. Собрать толстый JAR со всеми зависимостями через Shadow(как треуется по ТЗ):
   ```bash
   ./gradlew shadowJar
   ```
   После этого ищите JAR-файл в `build/libs/` — его можно запускать командой:
   ```bash
   java -jar build/libs/shift-course-task-1.0-SNAPSHOT-all.jar -s -a -p sample- in1.txt in2.txt
   ```

6. Если всё хорошо то в консоли увидите инфу, а в папке проекта появятся файлы

### -help

```bash
   java -jar build/libs/shift-course-task-1.0-SNAPSHOT-all.jar \
   [-a] [-s | -f] [-o <outputDir>] [-p <prefix>] file1 [file2 ...]
```

- `-a`  
  Записывать данные в существующие файлы. Без этого флага файлы будут перезаписаны
- `-s` или `-f`
   - `-s`: краткая статистика, только счётчик элементов
   - `-f`: полная статистика, для чисел – мин, макс, сумма, среднее, для строк – длины минимальной и максимальной
- `-o <outputDir>`
  Папка для сохранения выходных файлов (по умолчанию текущая директория)
- `-p <prefix>`
  Префикс, который добавляется к именам выходных файлов
- `file1 [file2 ...]` 
  Один или несколько входных файлов, из которых, беруться данные

## Контакты для связи

📧 Email: vova-gorohov04@mail.ru  
📱 Telegram: [@VGorPlay](https://t.me/VGorPlay)
