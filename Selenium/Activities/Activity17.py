from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support.select import Select

with webdriver.Firefox() as driver:

    driver.get("https://training-support.net/webelements/selects")

    print("Page title is:", driver.title)

    select_element = driver.find_element(
        By.CSS_SELECTOR, "select.h-80"
    )

    multi_select = Select(select_element)

    multi_select.select_by_visible_text("HTML")

    for i in range(3, 6):
        multi_select.select_by_index(i)

    multi_select.select_by_value("nodejs")

    selected_options = multi_select.all_selected_options

    print("Selected options are:")

    for option in selected_options:
        print(option.text)

    multi_select.deselect_by_index(4)

    selected_options = multi_select.all_selected_options

    print("Selected options after deselecting:")

    for option in selected_options:
        print(option.text)