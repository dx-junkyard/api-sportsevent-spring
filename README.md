# api-sportsevent-spring


### イベント追加リクエストの例
```
curl -XPOST -H "Content-Type: application/json"  http://localhost:8080/v1/api/event -d'{"title":"ボッチャ体験会","timeFrom":"2023-05-21 10:00","timeTo":"2023-05-21 14:00","ownerId":"xxxxx_owner_xxxx_id", "comment":"どなたでも参加いただけます","eventType":1, "sportEventIdList":[1]}'
```

### イベント情報取得リクエストの例（eventId=4の場合）
```
curl -XGET http://localhost:8080/v1/api/event?eventId=4
```