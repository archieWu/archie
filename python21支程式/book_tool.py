#!/usr/bin/env python
# coding: utf-8

# In[ ]:


from datetime import datetime, timedelta
import csv
import pandas as pd
import book_change
import book_del
import book_matplotlib
class book():
    def save_income(save):
        income='記帳本收入.csv'
        with open(income,'a',newline='',encoding='utf8')as income:
            csvW=csv.writer(income)
            csvW.writerow(save)
    def save_outlay(save):
        outlay='記帳本支出.csv'
        with open(outlay,'a',newline='',encoding='utf8')as outlay:
            csvW=csv.writer(outlay)
            csvW.writerow(save)
    def show_menu():
        """顯示菜單
        """
        print("歡迎使用【記帳本】")
        print("")
        print("1. 新增") 
        print("2. 修改") 
        print("3. 刪除") 
        print("4. 顯示表格")
        print("5. 顯示圓餅圖")
        print("")
        print("0. 退出系統")
        print("-" * 60)
    def new():
        while True:
            date=datetime.now().strftime('%Y/%m/%d')
            select = input("請選擇要記帳的內容1.收入2.支出0.結束:")
            if select == '1':
                types = input("請輸入類型1.薪水2.兼職3.投資4.零用錢5.其他：")
                ex = input("請輸入敘述：")
                money = input("請輸入金額：")
                if types=='1':
                    types='薪水'
                if types=='2':
                    types='兼職'
                if types=='3':
                    types='投資'
                if types=='4':
                    types='零用錢'
                if types=='5':
                    types='其他'
                save=[date,types,ex,money]
                book.save_income(save)
                print("成功添加一筆資料")
            if select == '2':
                types = input("請輸入類型1.飲食2.日常3.交通4.娛樂5.醫療6.其他：")
                ex = input("請輸入敘述：")
                money = input("請輸入金額：")
                if types=='1':
                    types='飲食'
                if types=='2':
                    types='日常'
                if types=='3':
                    types='交通'
                if types=='4':
                    types='娛樂'
                if types=='5':
                    types='醫療'
                if types=='6':
                    types='其他'
                save=[date,types,ex,money]
                book.save_outlay(save)
                print("成功添加一筆資料")
            if select=='0':
                return
    def change():
        book_change.tool()
    def delete():
        book_del.delete()
    def show_all():
        income=pd.read_csv('記帳本收入.csv',engine='python',encoding='utf8')
        print(income)
        income_sum = income['金額'].sum()
        print("總共是:%d"%income_sum)
        print('-'*60)
        outlay=pd.read_csv('記帳本支出.csv',engine='python',encoding='utf8')
        print(outlay)
        outlay_sum = outlay['金額'].sum()
        print("總共是:%d"%outlay_sum)
        print('-'*60)
        allsum=income_sum-outlay_sum
        print('餘額:%d'%allsum)
        print('*'*60)

    def matplotlib():
        ch=eval(input("要輸出哪個圓餅圖呢:1.收入2.支出"))
        if ch==1:
            book_matplotlib.income()
        if ch==2:
            book_matplotlib.outlay()


