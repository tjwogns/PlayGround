package com.example.playground.content.activityFlag

import android.os.Bundle
import com.example.playground.R
import com.example.playground.base.BaseActivity
import com.example.playground.databinding.ActivityActivityFlagBinding
import org.koin.androidx.viewmodel.ext.android.viewModel


class ActivityFlagActivity : BaseActivity<ActivityActivityFlagBinding, ActivityFlagViewModel>(
    R.layout.activity_activity_flag
) {

    override val viewModel: ActivityFlagViewModel by viewModel()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setListener()
    }

    private fun setListener() {
    }

    companion object {
    }

    /**
     *
     * ## Intent.FLAG_ACTIVITY_BROUGHT_TO_FRONT
     *
     * 앞으로 가져감 : This flag is not normally set by application code, but set for you by the system as described in the launchMode documentation for the singleTask mode.
     * 시스템 default Flag.
     * 시스템에 의해 스택 관리되며 가장 기본 값임.
     *
     *
     * ## Intent.FLAG_ACTIVITY_NEW_TASK
     *
     * 새로운 태스크 생성 : If set, this activity will become the start of a new task on this history stack.
     * 실행하는 액티비티를 새 태스크로 생성.
     * affinity(동족)가 있으면 그 태스크로 들어감.
     *
     * 예> 앱에서 시스템 설정을 열 때,
     * 기존에 열어둔게 없으면 -> 새로 태스크 생성. (A1) -> 태스크[A1]
     * 기존에 열어둔게 있으면 (A1) -> 그 태스크로 들어감. (A2) -> 태스크[A1, A2]
     *
     * *FLAG_ACTIVITY_MULTIPLE_TASK와 함께 사용하면 태스크는 무조건 새로 생성.
     *
     *
     * ## Intent.FLAG_ACTIVITY_CLEAR_TOP
     *
     * 상위 스택 제거 : If set, and the activity being launched is already running in the current task, then instead of launching a new instance of   * that activity, all of the other activities on top of it will be closed and this Intent will be delivered to the (now on top) old activity   * as a new Intent.
     * 실행하는 액티비티가 스택에 있으면 새로 시작하지 않고 상위 스택 모두 제거.
     *
     * 예> [ABCDE]가 있고, E에서 C를 열면 상위 DE제거
     *
     *
     * ## Intent.FLAG_ACTIVITY_SINGLE_TOP
     *
     * 하나의 탑 : If set, the activity will not be launched if it is already running at the top of the history stack.
     * 액티비티가 이미 최상단에 있으면 다시 시작하지 않고 재사용.
     *
     * 예> [ABCDE]가 있고, E에서 E를 열면 onPause()->onNewIntent() -> onResume()
     *
     * ## Intent.FLAG_ACTIVITY_CLEAR_TASK // 실행 액티비티 외 모두 제거
     * ## Intent.FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS // 최근 목록에서 제외.
     * ## Intent.FLAG_ACTIVITY_FORWARD_RESULT // result를 상위로 보냄. startActivityForResult()에서 사용.
     * ## Intent.FLAG_ACTIVITY_PREVIOUS_IS_TOP //  onActivityResult()로 결과를 전달할 때 이전 액티비티로 돌아가도록 하기 위해 추가.
     * ## Intent.FLAG_ACTIVITY_LAUNCH_ADJACENT // 멀티 윈도우 시 사용.
     * ## Intent.FLAG_ACTIVITY_LAUNCHED_FROM_HISTORY // 시스템에 의해 설정됨. 최근 목록에서 실행되면 자동으로 붙음.
     * ## Intent.FLAG_ACTIVITY_MULTIPLE_TASK // FLAG_ACTIVITY_NEW_TASK와 함께 사용시 새 태스크 생성
     * ## Intent.FLAG_ACTIVITY_NEW_DOCUMENT // concurrent document 동시 문서에서 사용
     * ## Intent.FLAG_ACTIVITY_NO_ANIMATION // 액티비티 전환시 애니메이션 무시
     * ## Intent.FLAG_ACTIVITY_NO_HISTORY // 액티비티를 스택에 존재X (로딩화면 등)
     * ## Intent.FLAG_ACTIVITY_NO_USER_ACTION // onUserLeaveHint() 실행을 차단
     * ## Intent.FLAG_ACTIVITY_REORDER_TO_FRONT // 실행하는 액티비티를 최상위로 올려줌
     * ## Intent.FLAG_ACTIVITY_RESET_TASK_IF_NEEDED // 정리할 액티비티가 있으면 태스크를 리셋
     * ## Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET // 리셋하면 상위 태스크 모두 삭제
     * ## Intent.FLAG_ACTIVITY_TASK_ON_HOME // FLAG_ACTIVITY_NEW_TASK와 함께 사용. 현재 홈 태스크 위에 위치.
     * ## Intent.FLAG_ACTIVITY_MATCH_EXTERNAL // 전체 앱이 intent를 처리할 수 없을 때
     * ## Intent.FLAG_ACTIVITY_RETAIN_IN_RECENTS // 최근 목록에서 재실행할 수 있도록 유지.
     * ## Intent.FLAG_DEBUG_LOG_RESOLUTION // 디버깅 정보를 로그로 출력.
     * ## Intent.FLAG_INCLUDE_STOPPED_PACKAGES // stopped된 application도 target이 됨.
     * ## Intent.FLAG_EXCLUDE_STOPPED_PACKAGES // stopped된 application은 target이 되지 않음.
     * ## Intent.FLAG_FROM_BACKGROUND // 백그라운드 동작중을 알려줌.
     * ## Intent.FLAG_GRANT_PERSISTABLE_URI_PERMISSION // URI 지속 권한
     * ## Intent.FLAG_GRANT_PREFIX_URI_PERMISSION // URI prefix match 권한.
     * ## Intent.FLAG_GRANT_READ_URI_PERMISSION // URI 읽기 권한.
     * ## Intent.FLAG_GRANT_WRITE_URI_PERMISSION // URI 쓰기 권한.
     * ## Intent.FLAG_RECEIVER_FOREGROUND // 포그라운드로  변경
     * ## Intent.FLAG_RECEIVER_NO_ABORT // 리시버가 브로드캐스트를 중지 못함.
     * ## Intent.FLAG_RECEIVER_REGISTERED_ONLY // 동적 리시버만 브로드캐스트 받음.
     * ## Intent.FLAG_RECEIVER_REPLACE_PENDING // 중복된 브로드캐스트를 제거.
     * ## Intent.FLAG_RECEIVER_VISIBLE_TO_INSTANT_APPS // 브로드캐스트가 instant app의 수신자에게 표시.
     **/
}