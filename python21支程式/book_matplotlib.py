def income():
    import numpy as np
    import matplotlib.pyplot as plt
    import pandas as pd
    income=pd.read_csv('記帳本收入.csv',engine='python',encoding='utf8')
    salary=income['類型']=='薪水'
    salary_sum = income[salary]['金額'].sum()
    parttime=income['類型']=='兼職'
    parttime_sum = income[parttime]['金額'].sum()
    investment=income['類型']=='投資'
    investment_sum = income[investment]['金額'].sum()
    pocketmoney=income['類型']=='零用錢'
    pocketmoney_sum = income[pocketmoney]['金額'].sum()
    others=income['類型']=='其他'
    others_sum = income[others]['金額'].sum()
    activities=["薪水","兼職","投資","零用錢","其他"]
    moneyin=[salary_sum,parttime_sum,investment_sum,pocketmoney_sum,others_sum]
    colors=["lightgreen","lightblue","yellow","pink","red"]
    explode=[0,0,0,0,0]
    plt.pie(moneyin,labels=activities,colors=colors,
           shadow=True,explode=explode,autopct="%1.1f%%")
    plt.axis("equal")
    plt.show()
def outlay():
    import numpy as np
    import matplotlib.pyplot as plt
    import pandas as pd
    outlay=pd.read_csv('記帳本支出.csv',engine='python',encoding='utf8')
    diet=outlay['類型']=='飲食'
    diet_sum = outlay[diet]['金額'].sum()
    daily=outlay['類型']=='日常'
    daily_sum = outlay[daily]['金額'].sum()
    traffic=outlay['類型']=='交通'
    traffic_sum = outlay[traffic]['金額'].sum()
    entertainment=outlay['類型']=='娛樂'
    entertainment_sum = outlay[entertainment]['金額'].sum()
    Medicaltreatment=outlay['類型']=='醫療'
    Medicaltreatment_sum = outlay[Medicaltreatment]['金額'].sum()
    other=outlay['類型']=='其他'
    others_sum = outlay[other]['金額'].sum()
    activities=["飲食","日常","交通","娛樂","醫療","其他"]
    moneyout=[diet_sum,daily_sum,traffic_sum,entertainment_sum,Medicaltreatment_sum,others_sum]
    colors=["lightgreen","lightblue","yellow","pink","red","purple"]
    explode=[0,0,0,0,0,0]
    plt.pie(moneyout,labels=activities,colors=colors,
           shadow=True,explode=explode,autopct="%1.1f%%")
    plt.axis("equal")
    plt.show()