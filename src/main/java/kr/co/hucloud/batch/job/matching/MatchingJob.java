package kr.co.hucloud.batch.job.matching;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import kr.co.hucloud.batch.job.matching.service.MatchingService;
import kr.co.hucloud.batch.job.matching.vo.MatchingTeamMemberVO;
import kr.co.hucloud.batch.job.matching.vo.MatchingTeamVO;
import kr.co.hucloud.batch.job.matching.vo.MemberVO;
import kr.co.hucloud.batch.job.matching.vo.SimilarObject;
import kr.co.hucloud.batch.tool.HuCloudContext;

public class MatchingJob extends QuartzJobBean {

	private MatchingService matchingService;

	@Override
	protected void executeInternal(JobExecutionContext context) throws JobExecutionException {

		matchingService = HuCloudContext.getBean("matchingService");
		System.out.println("matching job call");
		List<MemberVO> femaleMember = matchingService.readAllFemale();
		List<MemberVO> maleMember = matchingService.readAllMale();
		Random random = new Random();

		int femaleCount = femaleMember.size();
		int maleCount = maleMember.size();
		List<Integer> matchedFemale = new ArrayList<>();
		List<Integer> matchedMale = new ArrayList<>();
		System.out.println(femaleCount);
		System.out.println(maleCount);

		if (femaleCount > 0 && maleCount > 0) {
			if (femaleCount <= maleCount) {
				for (int i = 0; i < femaleCount; i++) {
					int j= random.nextInt(femaleCount);
					while(matchedFemale.contains(j)) {
						j=random.nextInt(femaleCount);
					}
					matchedFemale.add(j);
					int k= random.nextInt(maleCount);
					while(matchedMale.contains(j)) {
						k=random.nextInt(maleCount);
					}
					matchedMale.add(k);
					matchingService.createSoloMatching(
							femaleMember.get(j).getMemberId()
							, maleMember.get(k).getMemberId());
				}
			} else {
				for (int i = 0; i < maleCount; i++) {
					int j= random.nextInt(femaleCount);
					while(matchedFemale.contains(j)) {
						j=random.nextInt(femaleCount);
					}
					matchedFemale.add(j);
					int k= random.nextInt(maleCount);
					while(matchedMale.contains(j)) {
						k=random.nextInt(maleCount);
					}
					matchedMale.add(k);
					matchingService.createSoloMatching(
							femaleMember.get(j).getMemberId()
							, maleMember.get(k).getMemberId());
				}
			}
		}
		
		for(int teamNOP=2;teamNOP<6;teamNOP++) {
			List<MatchingTeamVO> femaleTeamList = matchingService.readAllTeamByGenderAndNOP("F",teamNOP);
			int femaleTeamListSize = femaleTeamList.size();
			for(int i=0; i<femaleTeamListSize; i++) {
				int matchingTeamId = femaleTeamList.get(i).getMatchingTeamId();
				List<MatchingTeamMemberVO> matchingTeamMemberVO = matchingService.readTeamMember(matchingTeamId);
				femaleTeamList.get(i).setMatchingTeamMemberVO(matchingTeamMemberVO);
				List<MatchingTeamMemberVO> teamMemberList = femaleTeamList.get(i).getMatchingTeamMemberVO();
				List<Integer> styleList = new ArrayList<>();
				List<Integer> preferStyleList = new ArrayList<>();
				for(int j=0; j<teamMemberList.size(); j++) {
					styleList.addAll(teamMemberList.get(j).getStyleList());
					preferStyleList.addAll(teamMemberList.get(j).getPreferStyleList());
				}
				femaleTeamList.get(i).setTeamStyleList(styleList);
				femaleTeamList.get(i).setTeamPreferStyleList(preferStyleList);
			}
			
			List<MatchingTeamVO> maleTeamList = matchingService.readAllTeamByGenderAndNOP("M",teamNOP);
			int maleTeamListSize = maleTeamList.size();
			for(int i=0; i<maleTeamListSize; i++) {
				int matchingTeamId = maleTeamList.get(i).getMatchingTeamId();
				List<MatchingTeamMemberVO> matchingTeamMemberVO = matchingService.readTeamMember(matchingTeamId);
				maleTeamList.get(i).setMatchingTeamMemberVO(matchingTeamMemberVO);
				List<MatchingTeamMemberVO> teamMemberList = maleTeamList.get(i).getMatchingTeamMemberVO();
				List<Integer> styleList = new ArrayList<>();
				List<Integer> preferStyleList = new ArrayList<>();
				for(int j=0; j<teamMemberList.size(); j++) {
					styleList.addAll(teamMemberList.get(j).getStyleList());
					preferStyleList.addAll(teamMemberList.get(j).getPreferStyleList());
				}
				maleTeamList.get(i).setTeamStyleList(styleList);
				maleTeamList.get(i).setTeamPreferStyleList(preferStyleList);
			}

			int[][] similarArray = new int[femaleTeamListSize][maleTeamListSize];
			for(int i=0; i<femaleTeamListSize; i++) {
				List<Integer> femaleTeamStyleList = femaleTeamList.get(i).getTeamStyleList();
				List<Integer> femaleTeamPreferStyleList = femaleTeamList.get(i).getTeamPreferStyleList();
				for(int j=0; j<maleTeamListSize; j++) {
					SimilarObject similarTmp = new SimilarObject();
					List<Integer> similarListFtoMTmp = new ArrayList<>();
					List<Integer> similarListMtoFTmp = new ArrayList<>();
					List<Integer> maleTeamStyleList = maleTeamList.get(j).getTeamStyleList();
					similarListFtoMTmp = femaleTeamPreferStyleList;
					similarListFtoMTmp.retainAll(maleTeamStyleList);
					
					List<Integer> maleTeamPreferStyleList = maleTeamList.get(i).getTeamPreferStyleList();
					similarListMtoFTmp = femaleTeamStyleList;
					similarListMtoFTmp.retainAll(maleTeamPreferStyleList);
					similarTmp.setAll(i, j, similarListFtoMTmp.size(), similarListMtoFTmp.size());
					similarArray[i][j] = similarTmp.similar();
				}
			}
			System.out.println("---------------------------");
			for(int i=0; i<femaleTeamListSize; i++) {
				for(int j=0; j<maleTeamListSize; j++ ) {
					System.out.println("i,j = "+i+","+j);
					System.out.println(similarArray[i][j]);
				}
			}
			
			Boolean[][] matchingArray = new Boolean[femaleTeamListSize][maleTeamListSize];
			Boolean[][] matchingArrayChange = new Boolean[maleTeamListSize][femaleTeamListSize];
			int leftFemaleMatchingTeam = femaleTeamListSize;
			int leftMaleMatchingTeam = maleTeamListSize;
			System.out.println("leftFemaleMatchingTeam : "+leftFemaleMatchingTeam);
			System.out.println("leftMaleMatchingTeam : " + leftMaleMatchingTeam );
			while(leftFemaleMatchingTeam !=0 && leftMaleMatchingTeam != 0) {
				int maxSimilar = 0;
				int tempIndexI = 0;
				int tempIndexJ = 0;
				for(int i=0; i<femaleTeamListSize; i++ ) {
					if(Arrays.asList(matchingArray[i]).contains(true)) {
						System.out.println(i+" contains true");
					} else {
						for(int j=0; j<maleTeamListSize; j++ ) {
							if(Arrays.asList(matchingArrayChange[j]).contains(true)) {
								System.out.println(j+" contains true");
							} else {
								int similar = similarArray[i][j];
								if(similar > maxSimilar) {
									tempIndexI = i;
									tempIndexJ = j;
									maxSimilar = similar;
								}
							}
						}
					}
				}
				matchingArray[tempIndexI][tempIndexJ] = true;
				matchingArrayChange[tempIndexJ][tempIndexI] = true;
				
				int leftFemaleTeamTmp = 0;
				int leftMaleTeamTmp = 0;
				for(int i=0; i<femaleTeamListSize; i++) {
					if(!Arrays.asList(matchingArray[i]).contains(true)) {
						leftFemaleTeamTmp += 1;
					}
				}
				
				for(int i=0; i<femaleTeamListSize; i++) {
					for(int j=0; j<maleTeamListSize; j++ ) {
						matchingArrayChange[j][i] = matchingArray[i][j];
					}
				}
				
				for(int i=0; i<maleTeamListSize; i++) {
					if(!Arrays.asList(matchingArrayChange[i]).contains(true)) {
						leftMaleTeamTmp += 1;
					}
				}
				leftFemaleMatchingTeam = leftFemaleTeamTmp;
				leftMaleMatchingTeam = leftMaleTeamTmp;
				System.out.println("leftFemaleTeamTmp : "+leftFemaleTeamTmp );
				System.out.println("leftMaleTeamTmp : "+leftMaleTeamTmp);
			}
			
			for(int i=0; i<femaleTeamListSize; i++) {
				for(int j=0; j<maleTeamListSize; j++ ) {
					if(matchingArray[i][j] != null) {
						if(matchingArray[i][j] == true) {
							matchingService.createTeamMatching(
									femaleTeamList.get(i).getMatchingTeamId()
									, maleTeamList.get(j).getMatchingTeamId()
									, teamNOP);
						}
					}
				}
			}
				
		}
		
	}
}
