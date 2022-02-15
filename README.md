# ExchangeWebService
# 스프링을 이용해서 다음과 같은 환율계산 웹 기능을 만듭니다.
첫화면은 다음과 같습니다.  

<kbd>
 <img src="https://github.com/wirebarley/apply/blob/master/images/coding_test1.png">
</kbd>

- 송금국가는 미국으로 고정입니다. 통화는 미국달러(USD)입니다. 
- 수취국가는 한국, 일본, 필리핀 세 군데 중 하나를 select box로 선택합니다. 각각 통화는 KRW, JPY, PHP 입니다.
- 수취국가를 선택하면 아래 환율이 바뀌어나타나야 합니다. 환율은 1 USD 기준으로 각각 KRW, JPY, PHP의 대응 금액입니다.
- 송금액을 USD로 입력하고 Submit을 누르면 아래 다음과 같이 수취금액이 KRW, JPY, PHP 중 하나로 계산되어서 나와야 합니다.
- 환율과 수취금액은 소숫점 2째자리까지, 3자리 이상 되면 콤마를 가운데 찍어 보여줍니다. 예를 들어 1234라면 1,234.00으로 나타냅니다.

<kbd>
 <img src="https://github.com/wirebarley/apply/blob/master/images/coding_test3.png">
</kbd>

- 환율정보는 https://currencylayer.com/ 의 무료 서비스를 이용해서 실시간으로 가져와야 합니다. 웹 서버가 시작될 때 한번 가져와서 계속 사용해도 되고, 매번 새로운 환율 정보를 가져와도 됩니다. 
- 새로운 무료 계정을 등록해서 API 키를 받아서 사용하면 됩니다. 샘플로 등록된 계정의 키를 예를 들면 다음과 같습니다.
<http://www.apilayer.net/api/live?access_key=ee50cd7cc73c9b7a7bb3d9617cfb6b9c>

결과로 다음과 같이 JSON으로 된 환율정보를 돌려받습니다.
