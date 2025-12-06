import pandas as pd

df = pd.read_excel("contacts.xlsx")

rows, columns = df.shape
print(f"✅ Number of Rows: {rows}")
print(f"✅ Number of Columns: {columns}\n")

print("📧 Emails Column:")
print(df["Email"], "\n")


print("📋 Data Sorted by FirstName (Ascending):")
sorted_df = df.sort_values("FirstName")
print(sorted_df)