import csv
import pandas as pd
import numpy as np
def delete(): 
    x=input("請問要刪除1.收入2.支出:")
    if x=='1':
        fn='記帳本收入.csv'
    if x=='2':
        fn='記帳本支出.csv'
    income=pd.read_csv(fn,engine='python',encoding='utf8')
    print(income)
    number=eval(input("請輸入要刪除的行數:"))
    income.drop(income.index[[number]],inplace=True)
    income.to_csv(fn, index=False)
    income=pd.read_csv(fn,engine='python',encoding='utf8')
    print('-'*60)
    print(income)
    print("刪除成功")
