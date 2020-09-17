#!/usr/bin/env python
# coding: utf-8

# In[9]:



import csv
import pandas as pd
def change(fn,x,number,content):
    income=pd.read_csv(fn,engine='python',encoding='utf8')
    income.iloc[number,x] = content
    income.to_csv(fn, index=False)
    income=pd.read_csv(fn,engine='python',encoding='utf8')
    print('-'*60)
    print(income)
def tool():
    x=input("請問要修改1.收入2.支出:")
    if x=='1':
        fn='記帳本收入.csv'
    if x=='2':
        fn='記帳本支出.csv'
    income=pd.read_csv(fn,engine='python',encoding='utf8')
    print(income)
    cheng=str(input("請輸入要修改的標題:"))
    number=eval(input("請輸入要修改的行數:"))
    content=input("請輸入要修改的內容:")
    if cheng=='日期':
        x=0
    if cheng=='類型':
        x=1
    if cheng=='說明':
        x=2
    if cheng=='金額':
        x=3
        content=eval(content)
    change(fn,x,number,content)
    print("修改成功")

