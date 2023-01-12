import sys

asset = int(sys.stdin.readline().rstrip())
share_price = sys.stdin.readline().rstrip().split(' ')

j_asset = asset
j_stock = 0

s_asset = asset
s_stock = 0

upstreak = 0
downstreak = 0
yesterday = 0
today = 0

for i in share_price:
    today = int(i)

    j_howmany = j_asset // today
    j_stock += j_howmany
    j_asset -= j_howmany * today
        
    if yesterday == 0:
        yesterday = today
        
    if today > yesterday:
        upstreak += 1
        downstreak = 0
    elif yesterday > today:
        downstreak += 1
        upstreak = 0
    else:
        upstreak = 0
        downstreak = 0
        
    if upstreak > 2:
        s_asset += s_stock * today
        s_stock = 0

    elif downstreak > 2:
        s_howmany = s_asset // today
        s_stock += s_howmany
        s_asset -= s_howmany * today
        
    yesterday = today

        
j_asset += j_stock * today
s_asset += s_stock * today

if j_asset > s_asset:
    print('BNP')
elif s_asset > j_asset:
    print('TIMING')
else:
    print('SAMESAME')