def solution(id_list, report, k):
    report_map = {id: set() for id in id_list}
    reported_map = {id: set() for id in id_list}
    
    for report_info in report:
        report_user, reported_user = report_info.split()
        report_map[report_user].add(reported_user)
        reported_map[reported_user].add(report_user)
    
    answer = []
    for id in id_list:
        count = 0
        for reported_user in report_map[id]:
            if len(reported_map[reported_user]) >= k:
                count += 1
        answer.append(count)
    
    return answer
